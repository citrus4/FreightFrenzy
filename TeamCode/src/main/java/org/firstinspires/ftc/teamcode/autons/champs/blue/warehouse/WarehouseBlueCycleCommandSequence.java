package org.firstinspires.ftc.teamcode.autons.champs.blue.warehouse;

import com.arcrobotics.ftclib.command.SequentialCommandGroup;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.subsystems.Drivetrain;
import org.firstinspires.ftc.teamcode.subsystems.DuckWheels;
import org.firstinspires.ftc.teamcode.subsystems.Intake;
import org.firstinspires.ftc.teamcode.subsystems.Lift;

public class WarehouseBlueCycleCommandSequence extends SequentialCommandGroup {
    public WarehouseBlueCycleCommandSequence(Drivetrain drivetrain, Intake intake, DuckWheels duckWheels, Lift lift, Telemetry telemetry) {

        addCommands(

        );
    }
}