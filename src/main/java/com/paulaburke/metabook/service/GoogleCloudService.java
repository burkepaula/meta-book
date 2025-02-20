package com.paulaburke.metabook.service;

import com.google.cloud.language.v1.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class GoogleCloudService {

    @Value("${google.cloud.apiKey}")
    private String apiKey;

    public String analyzeSentiment(String text) {
        try (LanguageServiceClient language = LanguageServiceClient.create()) {
            Document doc = Document.newBuilder()
                    .setContent(text)
                    .setType(Document.Type.PLAIN_TEXT)
                    .build();

            AnalyzeSentimentResponse response = language.analyzeSentiment(doc);
            Sentiment sentiment = response.getDocumentSentiment();
            return "Score: " + sentiment.getScore() + ", Magnitude: " + sentiment.getMagnitude();
        } catch (IOException e) {
            e.printStackTrace();
            return "Error during analysis";
        }
    }

    public String generateReview(String text) {
        try (LanguageServiceClient language = LanguageServiceClient.create()) {
            Document doc = Document.newBuilder()
                    .setContent(text)
                    .setType(Document.Type.PLAIN_TEXT)
                    .build();
            AnalyzeSentimentResponse response = language.analyzeSentiment(doc);
            Sentiment sentiment = response.getDocumentSentiment();

            String generatedReview = "O sentimento desta crítica é ";
            if (sentiment.getScore() >= 0.1) {
                generatedReview += "positivo: " + sentiment.getScore();
            } else if (sentiment.getScore() <= -0.1) {
                generatedReview += "negativo: " + sentiment.getScore();
            } else {
                generatedReview += "neutro: " + sentiment.getScore();
            }
            return generatedReview;
        } catch (IOException e) {
            e.printStackTrace();
            return "Erro durante a análise.";
        }
    }
}
