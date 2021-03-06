package cn.com.sjtu;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;

public class GroupProvider extends ContentProvider {
	private static final String TAG = "ContactsProvider";

	private DBHelper dbHelper;
	private SQLiteDatabase contactsDB;

	public static final String AUTHORITY = "cn.com.sjtu.provider.group";

	public static final Uri GROUP_URI = Uri.parse("content://" + AUTHORITY
			+ "/groups");

	public static final int CONTACTS = 1;
	public static final int CONTACT_ID = 2;
	private static final UriMatcher uriMatcher;

	static {
		uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
		uriMatcher.addURI(AUTHORITY, "groups", CONTACTS);
		// 单独列
		uriMatcher.addURI(AUTHORITY, "groups/#", CONTACT_ID);
	}

	@Override
	public boolean onCreate() {
		dbHelper = new DBHelper(getContext());
		contactsDB = dbHelper.getWritableDatabase();
		return (contactsDB == null) ? false : true;
	}

	// 删除指定数据列
	@Override
	public int delete(Uri uri, String where, String[] selectionArgs) {
		// TODO Auto-generated method stub
		int count;
		switch (uriMatcher.match(uri)) {
		case CONTACTS:
			count = contactsDB.delete(DBHelper.CONTACTS_GROUP_TABLE, where,
					selectionArgs);
			break;
		case CONTACT_ID:
			String contactID = uri.getPathSegments().get(1);
			count = contactsDB.delete(DBHelper.CONTACTS_GROUP_TABLE,
					ContactColumn._ID
							+ "="
							+ contactID
							+ (!TextUtils.isEmpty(where) ? " AND (" + where
									+ ")" : ""), selectionArgs);

			ContentValues values = new ContentValues();
			values.put(ContactColumn.GROUPNUM, 1);
			contactsDB
					.update(DBHelper.CONTACTS_USER_TABLE, values,
							ContactColumn.GROUPNUM + " = ?",
							new String[] { contactID });
			break;
		default:
			throw new IllegalArgumentException("Unsupported URI: " + uri);
		}
		getContext().getContentResolver().notifyChange(uri, null);
		return count;
	}

	// URI类型转换
	@Override
	public String getType(Uri uri) {
		// TODO Auto-generated method stub
		switch (uriMatcher.match(uri)) {
		case CONTACTS:
			return "vnd.android.cursor.dir/cn.com.sjtu.contact";
		case CONTACT_ID:
			return "vnd.android.cursor.item/cn.com.sjtu.contact";
		default:
			throw new IllegalArgumentException("Unsupported URI: " + uri);
		}
	}

	// 插入数据
	@Override
	public Uri insert(Uri uri, ContentValues initialValues) {

		if (uriMatcher.match(uri) != CONTACTS) {
			throw new IllegalArgumentException("Unknown URI " + uri);
		}

		ContentValues values;
		if (initialValues != null) {
			values = new ContentValues(initialValues);
			Log.e(TAG + "insert", "initialValues is not null");
		} else {
			values = new ContentValues();
		}
		if (values.containsKey(ContactColumn.GROUP_NAME) == false) {
			values.put(ContactColumn.NAME, "");
			Log.e(TAG + "insert", "NAME is null");
		}
		Log.e(TAG + "insert", values.toString());
		long rowId = contactsDB.insert(DBHelper.CONTACTS_GROUP_TABLE, null,
				values);
		if (rowId > 0) {
			Uri noteUri = ContentUris.withAppendedId(GROUP_URI, rowId);
			getContext().getContentResolver().notifyChange(noteUri, null);
			Log.e(TAG + "insert", noteUri.toString());
			return noteUri;
		}

		throw new SQLException("Failed to insert row into " + uri);

	}

	// 查询数据
	@Override
	public Cursor query(Uri uri, String[] projection, String selection,
			String[] selectionArgs, String sortOrder) {
		Log.e(TAG + ":query", " in Query");
		SQLiteQueryBuilder qb = new SQLiteQueryBuilder();
		qb.setTables(DBHelper.CONTACTS_GROUP_TABLE);

		switch (uriMatcher.match(uri)) {
		case CONTACT_ID:
			qb.appendWhere(ContactColumn._ID + "="
					+ uri.getPathSegments().get(1));
			break;
		default:
			break;
		}
		String orderBy;
		if (TextUtils.isEmpty(sortOrder)) {
			orderBy = ContactColumn._ID;
		} else {
			orderBy = sortOrder;
		}
		Cursor c = qb.query(contactsDB, projection, selection, selectionArgs,
				null, null, orderBy);

		c.setNotificationUri(getContext().getContentResolver(), uri);

		return c;

	}

	@Override
	public int update(Uri uri, ContentValues values, String selection,
			String[] selectionArgs) {
		// TODO Auto-generated method stub
		return 0;
	}
}
