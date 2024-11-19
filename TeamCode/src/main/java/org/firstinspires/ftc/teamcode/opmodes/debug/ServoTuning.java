package org.firstinspires.ftc.teamcode.opmodes.debug;
import com.acmerobotics.dashboard.FtcDashboard;
import com.acmerobotics.dashboard.config.Config;
import com.acmerobotics.dashboard.telemetry.MultipleTelemetry;
import com.arcrobotics.ftclib.controller.PIDController;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.core.Motors;
import org.firstinspires.ftc.teamcode.core.Sensors;
import org.firstinspires.ftc.teamcode.core.Servos;
import org.firstinspires.ftc.teamcode.core.params.RobotParameters;

@TeleOp
public class ServoTuning extends LinearOpMode
{
    @Config
    public static class Tune {
        public static double intakeLiftPosition = RobotParameters.ServoBounds.intakeFolded;
        public static double intakeYawPosition = RobotParameters.ServoBounds.intakeYawZero;
        public static double intakeClawPosition = 0.0;

        public static double armServo = 0.0;
        public static double outtakeClaw = 0.0;

        public static double aP = 0.0;
        public static double bI = 0.0;
        public static double cD = 0.0;

        public static double oP = 0.0;
        public static double pI = 0.0;
        public static double qD = 0.0;

        public static double oF = 0.0;

        public static double idTarget = 0.0;
        public static double odTarget = 0.0;
    }

    @Override
    public void runOpMode() throws InterruptedException
    {
        PIDController intakeController = new PIDController(Tune.aP, Tune.bI, Tune.cD);
        PIDController outtakeController = new PIDController(Tune.aP, Tune.bI, Tune.cD);
        Servos servos = new Servos(hardwareMap);
        Motors motors = new Motors(hardwareMap);

        if (isStopRequested()) return;
        waitForStart();

        telemetry = new MultipleTelemetry(telemetry, FtcDashboard.getInstance().getTelemetry());
        // Main loop
        while (opModeIsActive()) {
            intakeController.setPID(Tune.aP, Tune.bI, Tune.cD);
            outtakeController.setPID(Tune.oP, Tune.pI, Tune.qD);
            double intakeResponse = intakeController.calculate(motors.intakePosition(), Tune.idTarget);
            double outtakeResponse = outtakeController.calculate(motors.outtakePosition(), Tune.odTarget);

            if (Tune.odTarget > 10.0) {
                outtakeResponse += Tune.oF;
            }

            motors.intakeSlide.set(intakeResponse);

            motors.rightOuttakeSlide.set(outtakeResponse);
            motors.leftOuttakeSlide.set(outtakeResponse);

            servos.intakeLiftServo.setPosition(Tune.intakeLiftPosition);
            servos.intakeYawServo.setPosition(Tune.intakeYawPosition);
            servos.intakeClawServo.setPosition(Tune.intakeClawPosition);

            servos.outtakeClawServo.setPosition(Tune.outtakeClaw);
            servos.leftArmServo.setPosition(1.0 - Tune.armServo);
            servos.rightArmServo.setPosition(Tune.armServo);

            telemetry.addData("intake_pos", motors.intakePosition());
            telemetry.addData("outtake_pos_r", motors.rightOuttakeSlide.getCurrentPosition());
            telemetry.addData("outtake_pos_l", motors.leftOuttakeSlide.getCurrentPosition());
            telemetry.addData("tar", Tune.odTarget);
            telemetry.update();
        }
    }
}