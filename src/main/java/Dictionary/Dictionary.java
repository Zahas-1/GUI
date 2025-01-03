package Dictionary;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * A simple dictionary implementation that stores words and their translations.
 * Provides functionality to add words, retrieve translations, and get a random word.
 */
public class Dictionary {
    // List to store unique words
    private List<String> words;

    // Map to store word-translation pairs
    private Map<String, String> translations;

    /**
     * Constructor for the Dictionary class.
     * Initializes the words list and the translations map.
     * Adds a default word-translation pair ("sana" -> "word").
     */
    public Dictionary() {
        this.words = new ArrayList<>(); // Initialize the list of words
        this.translations = new HashMap<>(); // Initialize the map for translations
        add("sana", "word"); // Add a default word and its translation
    }

    /**
     * Retrieves the translation for a given word.
     *
     * @param word The word to be translated.
     * @return The translation of the word, or null if the word is not in the dictionary.
     */
    public String get(String word) {
        return this.translations.get(word); // Fetch the translation from the map
    }

    /**
     * Adds a new word-translation pair to the dictionary.
     * If the word is already in the dictionary, updates its translation.
     *
     * @param word        The word to be added.
     * @param translation The translation of the word.
     */
    public void add(String word, String translation) {
        // Add the word to the list if it's not already in the dictionary
        if (!this.translations.containsKey(word)) {
            this.words.add(word);
        }
        // Add or update the word-translation pair in the map
        this.translations.put(word, translation);
    }

    /**
     * Retrieves a random word from the dictionary.
     *
     * @return A random word from the dictionary.
     */
    public String getRandomWord() {
        Random random = new Random(); // Create a Random object
        // Get a random word from the list of words
        return this.words.get(random.nextInt(this.words.size()));
    }
}
