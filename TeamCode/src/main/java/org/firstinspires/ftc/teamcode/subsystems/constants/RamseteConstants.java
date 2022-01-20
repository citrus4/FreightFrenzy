package org.firstinspires.ftc.teamcode.subsystems.constants;

import com.acmerobotics.dashboard.config.Config;

@Config
public class RamseteConstants {
    //horizontal error adjustment
    public static double b = 12;
    public static double zeta = 1.4;

    //minimize overshoot
    public static double kLinear = 0.1;
    public static double kHeading = 7;
}