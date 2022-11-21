package com.stuypulse.robot.commands;

import com.stuypulse.robot.util.Motor;

public class DriveFunctions {
    static double target_distance = 120;

    public static void driveForwards(Motor left, Motor right) {
        left.set(1.0);
        right.set(1.0);
    }

    public static void driveBackwards(Motor left, Motor right) {
        left.set(-1.0);
        right.set(-1.0);
    }

    public static void turnRight(Motor left, Motor right) {
        left.set(1.0);
    }

    public static void turnLeft(Motor left, Motor right) {
        right.set(1.0);
    }

    public static void arcRight(Motor left, Motor right) {
        left.set(1.0);
        right.set(0.5);
    }

    public static void arcLeft(Motor left, Motor right) {
        right.set(1.0);
        left.set(0.5);
    }

    public static void stopDistance(Motor left, Motor right) {
        if (left.getDistance() < target_distance) {
            left.set(1);
            right.set(1);
        } else {
            left.set(0);
            right.set(0);
        }
    }

    public static void bangBang(Motor left, Motor right) {
        if (left.getDistance() > target_distance) {
            double original_distance = left.getDistance();

            left.set(-1);
            right.set(-1);

            if (Math.abs(left.getDistance() - (original_distance + original_distance - 24)) < 1) {
                left.set(0);
                right.set(0);
            }
        } else {
            left.set(1);
            right.set(1);

            if (Math.abs(left.getDistance() - target_distance) < 1) {
                left.set(0);
                right.set(0);
            }
        }
    }

    public static void betterControl(Motor left, Motor right) {
        left.set((target_distance - left.getDistance()) / target_distance);
        right.set((target_distance - right.getDistance()) / target_distance);
    }

}
