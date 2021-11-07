package org.firstinspires.ftc.teamcode.autons.lm1.blue;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.geometry.Vector2d;
import com.arcrobotics.ftclib.command.SequentialCommandGroup;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.commands.drive.DriveForwardCommand;
import org.firstinspires.ftc.teamcode.commands.drive.SplineCommand;
import org.firstinspires.ftc.teamcode.commands.drive.TurnCommand;
import org.firstinspires.ftc.teamcode.commands.drive.TurnToCommand;
import org.firstinspires.ftc.teamcode.subsystems.Drivetrain;

public class BlueWarehouseCommandR extends SequentialCommandGroup {
    public BlueWarehouseCommandR(Drivetrain drivetrain, Telemetry telemetry) {
        //declare variables here


        addCommands(
                new DriveForwardCommand(drivetrain, -15)
        );
    }
}