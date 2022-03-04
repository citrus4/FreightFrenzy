package org.firstinspires.ftc.teamcode.autons.regionals.blue.carousel;

import com.arcrobotics.ftclib.command.SequentialCommandGroup;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.subsystems.Cap;
import org.firstinspires.ftc.teamcode.subsystems.Drivetrain;
import org.firstinspires.ftc.teamcode.subsystems.DuckWheels;
import org.firstinspires.ftc.teamcode.subsystems.Intake;
import org.firstinspires.ftc.teamcode.subsystems.Lift;

public class BlueRegionalsCarouselCCommand extends SequentialCommandGroup {
    public BlueRegionalsCarouselCCommand(Drivetrain drivetrain, Lift lift, Intake intake, DuckWheels duckWheels, Cap cap, Telemetry telemetry) {
        addCommands(
        );
    }
}
