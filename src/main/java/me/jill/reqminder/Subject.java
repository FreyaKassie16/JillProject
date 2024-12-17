package me.jill.reqminder;

import java.util.*;

public class Subject {
    private String name;
    private double weight;

    private Map<String, ArrayList<Requirement>> categorizedRequirements;
    private Map<String, Double> requirementTypeWeights;


    public Subject(String name, double weight, int quarter) {
        this.name = name;
        this.weight = weight;
        this.categorizedRequirements = new HashMap<>();
        this.requirementTypeWeights = new HashMap<>();
    }


    // Adds requirements under a category
    public void addRequirement(Requirement requirement) {
        String requirementType = requirement.getRequirementType();
        categorizedRequirements
            .computeIfAbsent(requirementType, k ->  new ArrayList<>())
            .add(requirement);
        System.out.println("Requirement added to category: " + requirementType + " in subject: " + name);
    }


    // Assign weights to each requirement type
    public void setRequirementTypeWeight(String requirementType, double weight) {
        if (weight < 0 || weight > 100) {
            // InvalidWeightException
            return;
        }
        requirementTypeWeights.put(requirementType, weight);
        
    }

    private boolean validateRequirementTypeWeights() {
        double totalWeight = 0.0;
        for (double weight : requirementTypeWeights.values()) {
            totalWeight += weight;
        }
        if (totalWeight != 100.0) {
            // InvalidRequirementTypeWeights
            System.out.println("Error: Total Requirement Type Weights is less than 100.");
            return false;
        }
        return true;
    }

    public double calculateGrade() {
        if (!validateRequirementTypeWeights()) {
            return 0.0; // return 0 if requirement type weights don't add up to 100
        }

        double totalWeightedScore = 0.0;
        double totalMaxScore = 0.0;

        // Loop through each requirement type and calculate its weighted contribution
        for (Map.Entry<String, ArrayList<Requirement>> entry: categorizedRequirements.entrySet()) {
            String requirementType = entry.getKey();
            ArrayList<Requirement> requirements = entry.getValue();
            double requirementTypeWeight = requirementTypeWeights.getOrDefault(requirementType, 0.0); // Get weight for each requirement type, default to 0 if not set

            double requirementTypeScore = 0.0;
            double requirementTypeMaxScore = 0.0;
            
            // Calculate total score and max score for this requirement type
            for (Requirement req : requirements) {
                requirementTypeScore += req.getScore();
                requirementTypeMaxScore += req.getMaxScore();
            }

            // If requirementTypeMaxScore is 0, skip this requirement type
            if (requirementTypeMaxScore > 0) {
                double requirementTypeGrade = (requirementTypeScore / requirementTypeMaxScore); // Requirement Type grade percentage
                totalWeightedScore += (requirementTypeGrade * requirementTypeWeight) / 100; // Weighted requirement type grade
                totalMaxScore += requirementTypeWeight; // Add the weight of the requirement type to the totalMaxScore
            }
        }

        // Calculate the overall grade based on all requirement types
        if (totalMaxScore > 0) {
            double overallGrade = (totalWeightedScore / totalMaxScore) * 100 * 100;
            System.out.println("Your grade in subject " + name + " is " + overallGrade);
            return overallGrade;
        } else {
            // NoRequirementsException
            System.out.println("No graded requirements found.");
            return 0.0;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public Map<String, ArrayList<Requirement>> getCategorizedRequirements() {
        return categorizedRequirements;
    }
}
