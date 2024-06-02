package com.capgemini.wsb.fitnesstracker.training.api;

import com.capgemini.wsb.fitnesstracker.training.internal.ActivityType;

public record TrainingDto() {

    private static ActivityType activityType;


    ;
    private static String name;

    public static void setName(String name) {
        TrainingDto.name = name;
    }

    public Object getName() {
        return name;
    }
    public String getActivityType() {
        return String.valueOf(activityType);
    }

    public void setActivityType(ActivityType activityType) {
        this.activityType = activityType;
    }
}
