package org.firstinspires.ftc.teamcode.subsystems.constants;

import com.acmerobotics.dashboard.config.Config;

@Config
public class RamseteConstants {
    //horizontal error adjustment
    public static double b = 15;//prev 18
    public static double zeta = 1.15;

    //minimize overshoot
    public static double kLinear = 1;
    public static double kHeading = 0.2;
}