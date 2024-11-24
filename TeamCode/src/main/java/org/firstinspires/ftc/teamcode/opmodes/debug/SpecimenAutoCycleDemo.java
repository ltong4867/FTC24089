package org.firstinspires.ftc.teamcode.opmodes.debug;
import com.acmerobotics.dashboard.FtcDashboard;
import com.acmerobotics.dashboard.config.Config;
import com.acmerobotics.dashboard.telemetry.MultipleTelemetry;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.auto.AutonomousRobot;

@TeleOp
public class SpecimenAutoCycleDemo extends LinearOpMode
{
    @Override
    public void runOpMode() throws InterruptedException
    {
        AutonomousRobot robot = new AutonomousRobot(telemetry, hardwareMap);
        if (isStopRequested()) return;
        waitForStart();

        telemetry = new MultipleTelemetry(telemetry, FtcDashboard.getInstance().getTelemetry());

        while (opModeIsActive()) {
            terminateOpModeNow();
        }
    }
}
