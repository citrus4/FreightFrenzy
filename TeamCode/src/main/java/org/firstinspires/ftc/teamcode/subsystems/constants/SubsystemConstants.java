package org.firstinspires.ftc.teamcode.subsystems.constants;

import com.qualcomm.robotcore.hardware.PIDFCoefficients;

public class SubsystemConstants {
    public static int DEGREES_PER_ROTATION = 360;

    public static class Lift {
        public static double DEL_CLOSE_POS = 0.38;
        public static double DEL_OPEN_POS = 0.6;

        public static int LIFT_RESTING_POSITION = 80;
        public static int LIFT_MID_POSITION = 400;
        public static int LIFT_HIGH_POSITION = 1020;//was 950, might want higher

        public static double LIFT_UP_SPEED = 1;
        public static double LIFT_DOWN_SPEED = -0.2;

        public static double LIFT_TICKS_PER_ROTATION = 384.5; //383.6
        //turn these down
        public static PIDFCoefficients LIFT_PID_COEFFICIENTS = new PIDFCoefficients(0.008, 0.00008, 0, 0);
        public static PIDFCoefficients LIFT_PID_COEFFICIENTS_DOWN = new PIDFCoefficients(0.0008, 0.00008, 0, 0);
        public static int LIFT_TOLERANCE = 10;

        public static String LIFT_MOTOR_ID = "lift";
        public static String DELIVERY_MOTOR_ID = "delivery";
        public static String DISTANCE_SENSOR_ID = "distance";
    }

    public static class Intake {
        public static double INTAKE_SPEED = 1;
        public static double OUTTAKE_SPEED = -1;

        public static String INTAKE_MOTOR_ID = "intake";
    }
//leo's fired for breaking the robot, 12
    public static class Arm {
        public static double ARM_UP_POS = 0.55;
        public static double ARM_DOWN_POS = 0.05;
        public static double ARM_SCORE_POS = 0.33;
        public static double ARM_REST_POS = 0.4;
        public static String ARM_SERVO_ID = "arm";
        //leo is fired//
    }

    public static class DuckWheels {
        public static double INTAKE_SPEED = 0.45;
        public static double OUTTAKE_SPEED = -0.45;
        public static String RIGHT_393_ID = "right_393";
        public static String LEFT_393_ID = "left_393";
    }
/*

leo is fired, haddon for head builder
 */
}