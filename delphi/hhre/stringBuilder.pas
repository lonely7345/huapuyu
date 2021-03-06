unit stringBuilder;

interface

uses
  SysUtils;

type
  TStringBuilder = class
  strict private
    value: string;
  public
    constructor Create;
    procedure Append(const value: string);
    function ToString: string; override;
  end;

implementation

constructor TStringBuilder.Create;
begin
  Self.value := EmptyStr;
end;

procedure TStringBuilder.Append(const value: string);
begin
  Self.value := Self.value + value;
end;

function TStringBuilder.ToString: string;
begin
  Result := Self.value;
end;

end.


