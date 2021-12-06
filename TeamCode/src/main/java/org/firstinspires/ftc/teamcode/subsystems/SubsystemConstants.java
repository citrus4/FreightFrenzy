package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.PIDFCoefficients;

public class SubsystemConstants {
    public static int DEGREES_PER_ROTATION = 360;

    public static class Lift {
        public static double DEL_OPEN_POS = 0.477;
        public static double DEL_CLOSE_POS = 0.038;

        public static int RESTING_POSITION = 130;
        public static int LOW_POSITION = 400;
        public static int MID_POSITION = 600;
        public static int HIGH_POSITION = 950;
        public static int CAP_POSITION = 1000;

        public static double UP_SPEED = 1;
        public static double DOWN_SPEED = -1;

        public static double LIFT_TICKS_PER_ROTATION = 384.5; //383.6
        public static PIDFCoefficients LIFT_PID_COEFFICIENTS = new PIDFCoefficients(0.005, 0.00008, 0, 0); //(0.005, 0.0001, 0.003, 0);
        public static PIDFCoefficients LIFT_PID_COEFFICIENTS_DOWN = new PIDFCoefficients(0.0008, 0.00008, 0, 0); //(0.005, 0.0001, 0.003, 0);
        public static int LIFT_TOLERANCE = 10;

        public static String LIFT_MOTOR_ID = "lift";
        public static String DELIVERY_MOTOR_ID = "delivery";
    }

    public static class Intake {
        public static double INTAKE_SPEED = 1;
        public static double OUTTAKE_SPEED = -1;

        public static String INTAKE_MOTOR_ID = "intake";
    }
//leo's fired for breaking the robot, 12
    public static class Arm {
        public static double ARM_UP_POS = 0.964;
        public static double ARM_DOWN_POS = 0.589;
        public static double ARM_SCORE_POS = 0.401;
        public static double ARM_REST_POS = 0.8;
        public static String ARM_SERVO_ID = "arm";
        //leo is fired//
    }
/*

leo is fired, haddon for head builder
 */
    public static class Vision {

    }
}