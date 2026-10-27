package javaDesignPatterns;

/**
 * Problem: Create a Command interface, a Light receiver,
 * LightOnCommand and LightOffCommand implementations, and a
 * RemoteControl that executes the selected command.
 *
 * Author : Hemang
 * Date   : 22-10-2026
 */

public class CommandPatternExample {

    // Define the common command operation.
    interface Command {
        void execute();
    }

    // Represent the device that performs the actual operation.
    static class Light {
        // Turn the light on.
        public void turnOn() {
            System.out.println("Light is ON");
        }

        // Turn the light off.
        public void turnOff() {
            System.out.println("Light is OFF");
        }
    }

    // Create a command to turn the light on.
    static class LightOnCommand implements Command {
        private Light light;

        // Store the light that this command controls.
        public LightOnCommand(Light light) {
            this.light = light;
        }

        // Execute the light-on operation.
        public void execute() {
            light.turnOn();
        }
    }

    // Create a command to turn the light off.
    static class LightOffCommand implements Command {
        private Light light;

        // Store the light that this command controls.
        public LightOffCommand(Light light) {
            this.light = light;
        }

        // Execute the light-off operation.
        public void execute() {
            light.turnOff();
        }
    }

    // Represent a remote control that executes commands.
    static class RemoteControl {
        private Command command;

        // Set the command for the remote control.
        public void setCommand(Command command) {
            this.command = command;
        }

        // Execute the selected command.
        public void pressButton() {
            if (command != null) {
                command.execute();
            } else {
                System.out.println("No command assigned");
            }
        }
    }

    // Test the Command pattern.
    public static void main(String[] args) {
        // Create the light and remote control.
        Light light = new Light();
        RemoteControl remote = new RemoteControl();

        // Assign and execute the light-on command.
        remote.setCommand(new LightOnCommand(light));
        remote.pressButton();

        // Assign and execute the light-off command.
        remote.setCommand(new LightOffCommand(light));
        remote.pressButton();
    }
}
