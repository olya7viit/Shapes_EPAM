package shapes.by.matusevich.controller;

public class Controller {

    private final String PARAM_DELIMITER = " ";

    public String executeTask(String request) {
        String command;
        command = request.substring(0, request.indexOf(PARAM_DELIMITER));

        command = command.toUpperCase();
        String response = null;

        switch (command) {
            case "SIGN_IN":    // do action (call services and others) and create a response
                break;
            case "ADD_BOOK":    // do action and create a response
                /*

               operationService.save(login, typeOperation, sum);
            response = "Successfully";
                 */
                break;
            default:
                response = "We can't execute this command";
        }
        return response;
    }
}
