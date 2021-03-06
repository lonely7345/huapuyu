package com.lts.core.protocol.command;

/**
 * 取消(删除)任务
 * @author Robert HG (254963746@qq.com) on 11/7/15.
 */
public class JobCancelRequest extends AbstractRemotingCommandBody{

    private String taskId;

    private String taskTrackerNodeGroup;

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getTaskTrackerNodeGroup() {
        return taskTrackerNodeGroup;
    }

    public void setTaskTrackerNodeGroup(String taskTrackerNodeGroup) {
        this.taskTrackerNodeGroup = taskTrackerNodeGroup;
    }
}
