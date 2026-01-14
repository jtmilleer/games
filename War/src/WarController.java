import cards.PlayingCard;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

public class WarController {

    @FXML private Label player1HandLabel;
    @FXML private Label player2HandLabel;
    @FXML private Label statusLabel;
    @FXML private ImageView player1CardView;
    @FXML private ImageView player2CardView;
    @FXML private Button playButton;
    @FXML private HBox faceDownBox1;
    @FXML private HBox faceDownBox2;

    private WarModel model;

    @FXML
    public void initialize() {
        // Create the model
        model = new WarModel();

        // Set up initial UI state
        updateHandLabels();

        // Set button action
        playButton.setOnAction(e -> handlePlayRound());
    }

    private void handlePlayRound() {
        // Clear previous war face-down cards
        clearWarFaceDownCards();

        // Check if game is over
        if (model.isGameOver()) {
            statusLabel.setText(model.getWinner());
            playButton.setDisable(true);
            return;
        }

        // Play a round
        String result = model.playRound();

        // Update the UI
        updateUI(result);
    }

    private void updateUI(String result) {
        // Update hand counts
        updateHandLabels();

        // Display current cards using the card's built-in image
        displayCard(player1CardView, model.getCurrentCardP1());
        displayCard(player2CardView, model.getCurrentCardP2());

        // Display face-down war cards if any
        displayWarFaceDownCards();

        // Update status message
        statusLabel.setText(result);

        // Check for game over
        if (model.isGameOver()) {
            statusLabel.setText(model.getWinner());
            playButton.setDisable(true);
        }
    }

    private void updateHandLabels() {
        player1HandLabel.setText(String.valueOf(model.getPlayer1HandSize()));
        player2HandLabel.setText(String.valueOf(model.getPlayer2HandSize()));
    }

    private void displayCard(ImageView imageView, PlayingCard card) {
        if (card != null) {
            // Use the card's getFace() method to get the image
            Image cardImage = card.getFace();
            if (cardImage != null) {
                imageView.setImage(cardImage);
            } else {
                // Fallback: try to load image if not set
                System.err.println("Card image not set for: " + card.getName());
                imageView.setImage(null);
            }
        } else {
            imageView.setImage(null);
        }
    }

    private void displayWarFaceDownCards() {
        faceDownBox1.getChildren().clear();
        faceDownBox2.getChildren().clear();

        // Display face-down cards for player 1
        for (PlayingCard card : model.getWarFaceDownP1()) {
            ImageView cardView = createCardView(card);
            faceDownBox1.getChildren().add(cardView);
        }

        // Display face-down cards for player 2
        for (PlayingCard card : model.getWarFaceDownP2()) {
            ImageView cardView = createCardView(card);
            faceDownBox2.getChildren().add(cardView);
        }
    }


    private ImageView createCardView(PlayingCard card) {
        ImageView cardView = new ImageView();
        cardView.setFitWidth(40);
        cardView.setFitHeight(60);
        cardView.setPreserveRatio(true);

        Image cardBack = card.getImage();
        if (cardBack != null) {
            cardView.setImage(cardBack);
        } else {
            System.err.println("Card back image not set");
        }

        return cardView;
    }



    private void clearWarFaceDownCards() {
        model.getWarFaceDownP1().clear();
        model.getWarFaceDownP2().clear();
        faceDownBox1.getChildren().clear();
        faceDownBox2.getChildren().clear();
    }

    // Optional: Method to reset the game
    public void resetGame() {
        model = new WarModel();
        updateHandLabels();
        player1CardView.setImage(null);
        player2CardView.setImage(null);
        clearWarFaceDownCards();
        statusLabel.setText("Click 'Play Round' to start!");
        playButton.setDisable(false);
    }
}