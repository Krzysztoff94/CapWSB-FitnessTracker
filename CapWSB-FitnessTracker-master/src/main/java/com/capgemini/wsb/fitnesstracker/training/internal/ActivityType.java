package com.capgemini.wsb.fitnesstracker.training.internal;

// TODO : JavaDoc

/**
 * Enum representing types of physical activities.
 */
public enum ActivityType {
    /**
     * Activity types.
     */
    RUNNING("Running"),
    /**
     * Cycling activity type.
     */
    CYCLING("Cycling"),
    /**
     * Walking activity type.
     */
    WALKING("Walking"),
    /**
     * Swimming activity type.
     */
    SWIMMING("Swimming"),
    /**
     * Tennis activity type.
     */
    TENNIS("Tenis");

    private final String displayName;



    /**
     * Constructor for ActivityType.
     *
     * @param displayName The display name of the activity type.
     */

    ActivityType(String displayName) {
        this.displayName = displayName;
    }


    /**
     * Get the display name of the activity type.
     *
     * @return The display name.
     */
    public String getDisplayName() {
        return displayName;
    }

}
