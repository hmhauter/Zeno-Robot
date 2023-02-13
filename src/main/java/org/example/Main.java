package org.example;

import org.robokind.api.common.position.NormalizedDouble;
import org.robokind.api.motion.*;
import org.robokind.api.motion.messaging.RemoteRobot;
import org.robokind.client.basic.Robokind;
import org.robokind.client.basic.RobotJoints;
import org.robokind.client.basic.UserSettings;


public class Main {
    public static void main(String[] args) {

        String ip_address = "192.168.252.1";

        System.out.println("Start...!");
        //Set up the address and robot ID
        UserSettings.setRobotAddress(ip_address);
        UserSettings.setRobotId("RKR251016100047");


        RemoteRobot robot = Robokind.connectRobot();



        System.out.println("Connected to Robot");

        Robot.JointId waist = new Robot.JointId(robot.getRobotId(), new Joint.Id(RobotJoints.WAIST));
        Robot.JointId leg = new Robot.JointId(robot.getRobotId(), new Joint.Id(RobotJoints.RIGHT_HIP_YAW));

        Robot.RobotPositionMap goalPositions = new Robot.RobotPositionHashMap();
        goalPositions.put(waist, new NormalizedDouble(1.0));
        goalPositions.put(leg, new NormalizedDouble(0.5));

        //Moves the joints to the specified goal positions over 1000 milliseconds
        robot.move(goalPositions, 1000);

        System.out.println("Done...!");
    }
}