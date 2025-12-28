package games;

public abstract class Game {

    private GameView view;
    private GameController controller;
    private GameModel model;

    public GameView getView() {
        return view;
    }

    public GameController getController() {
        return controller;
    }

    public GameModel getModel() {
        return model;
    }

    public void setView(GameView view) {
        this.view = view;
    }

    public void setController(GameController controller) {
        this.controller = controller;
    }

    public void setModel(GameModel model) {
        this.model = model;
    }
}
