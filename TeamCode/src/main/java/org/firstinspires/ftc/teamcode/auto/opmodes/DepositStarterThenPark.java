package org.firstinspires.ftc.teamcode.auto.opmodes;

import org.firstinspires.ftc.teamcode.auto.constants.Points;
import org.firstinspires.ftc.teamcode.auto.constants.Poses;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import org.firstinspires.ftc.teamcode.pedroPathing.localization.Pose;
import org.firstinspires.ftc.teamcode.pedroPathing.pathGeneration.BezierCurve;
import org.firstinspires.ftc.teamcode.pedroPathing.pathGeneration.Path;
import org.firstinspires.ftc.teamcode.pedroPathing.pathGeneration.PathChain;
import org.firstinspires.ftc.teamcode.pedroPathing.pathGeneration.Point;
import org.firstinspires.ftc.teamcode.pedroPathing.follower.Follower;

// This will start in the corner for blue and go from there
// Start facing toward the baskets with the center on the 45 degree angled corner of the human player area
@Autonomous(name = "TestPedroAuto", group = "Testing")
public class DepositStarterThenPark extends OpMode {
    public int autostate = 0;
    public PathChain chain;

    public Follower follower;


    @Override
    public void init() {
        this.follower = new Follower(hardwareMap);
        this.follower.setStartingPose(Points.slantStartPose);
        this.chain = org.firstinspires.ftc.teamcode.auto.paths.DepositStarterThenPark.path();
    }

    @Override
    public void start() {
        this.follower.update();
        this.follower.followPath(org.firstinspires.ftc.teamcode.auto.paths.DepositStarterThenPark.path());
    }

    @Override
    public void loop() {
        this.follower.update();
        if (this.follower.atParametricEnd()) { terminateOpModeNow(); }
    }
}
