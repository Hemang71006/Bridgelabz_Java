package javaDesignPatterns;

/**
 * Problem: Create an abstract Handler with a next-handler reference.
 * Implement TeamLead, Manager, and HR handlers to pass a request
 * through a chain until an appropriate handler approves it.
 *
 * Author : Hemang
 * Date   : 22-10-2026
 */

public class ChainOfResponsibilityExample {

    // Define the base class for all request handlers.
    abstract static class Handler {
        protected Handler nextHandler;

        // Connect this handler to the next handler.
        public void setNextHandler(Handler nextHandler) {
            this.nextHandler = nextHandler;
        }

        // Require each handler to process a leave request.
        abstract void approveLeave(int days);
    }

    // Handle short leave requests.
    static class TeamLead extends Handler {
        // Approve a request or pass it to the next handler.
        public void approveLeave(int days) {
            // Approve leave of up to two days.
            if (days <= 2) {
                System.out.println("Team Lead approved " + days + " day(s)");
            } else if (nextHandler != null) {
                // Forward longer requests.
                nextHandler.approveLeave(days);
            }
        }
    }

    // Handle medium-length leave requests.
    static class Manager extends Handler {
        // Approve a request or pass it to the next handler.
        public void approveLeave(int days) {
            // Approve leave of up to five days.
            if (days <= 5) {
                System.out.println("Manager approved " + days + " day(s)");
            } else if (nextHandler != null) {
                // Forward longer requests.
                nextHandler.approveLeave(days);
            }
        }
    }

    // Handle long leave requests.
    static class HR extends Handler {
        // Process the final request in the chain.
        public void approveLeave(int days) {
            // Approve requests within the HR limit.
            if (days <= 10) {
                System.out.println("HR approved " + days + " day(s)");
            } else {
                // Reject requests beyond the defined limit.
                System.out.println("Leave request exceeds the approval limit");
            }
        }
    }

    // Test the Chain of Responsibility pattern.
    public static void main(String[] args) {
        // Create the handlers.
        Handler teamLead = new TeamLead();
        Handler manager = new Manager();
        Handler hr = new HR();

        // Connect the handlers into a chain.
        teamLead.setNextHandler(manager);
        manager.setNextHandler(hr);

        // Send requests through the first handler.
        teamLead.approveLeave(2);
        teamLead.approveLeave(4);
        teamLead.approveLeave(8);
        teamLead.approveLeave(15);
    }
}
