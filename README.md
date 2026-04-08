# Data Privacy Toolkit

![Java](https://img.shields.io/badge/Java-11%2B-red)
![License](https://img.shields.io/badge/license-Apache_2.0-blue)

A robust Java-based toolkit providing a suite of functionalities for data anonymization, pseudonymization, and differential privacy. Designed for developers and data scientists working with sensitive information in AI/ML contexts.

## Features
- K-anonymity and L-diversity implementations
- Differential privacy mechanisms (Laplace, Gaussian)
- Data masking and tokenization
- Secure multi-party computation (conceptual integration)

## Building
```bash
mvn clean install
```

## Usage
```java
import com.dataprivacy.toolkit.anonymization.KAnonymity;
import com.dataprivacy.toolkit.differentialprivacy.LaplaceMechanism;

public class PrivacyExample {
    public static void main(String[] args) {
        // K-Anonymity example
        String[][] data = {
            {"age", "gender", "zip", "disease"},
            {"30", "M", "90210", "Flu"},
            {"32", "F", "90210", "Cold"},
            {"30", "M", "90210", "Flu"}
        };
        KAnonymity kAnon = new KAnonymity(data, new int[]{0, 1, 2}, 2);
        String[][] anonymizedData = kAnon.anonymize();
        System.out.println("Anonymized Data:");
        for (String[] row : anonymizedData) {
            System.out.println(String.join(", ", row));
        }

        // Differential Privacy example
        LaplaceMechanism laplace = new LaplaceMechanism(1.0); // epsilon = 1.0
        double sensitiveValue = 50.0;
        double privatizedValue = laplace.addNoise(sensitiveValue);
        System.out.println("
Original: " + sensitiveValue + ", Privatized: " + privatizedValue);
    }
}
```
