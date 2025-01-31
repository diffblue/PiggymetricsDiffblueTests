package com.piggymetrics.account.domain;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class LicenseChecker {

    @NotNull
    @Length(min = 25, max = 50)
    private static String VALID_LICENSE_KEY; // License key loaded dynamically

    public static void setValidLicenseKey(String licenseKey) {
        if (licenseKey == null || licenseKey.isEmpty() || licenseKey.length() < 25 || licenseKey.length() > 50) {
            throw new IllegalArgumentException("Invalid license key provided. It must be between 25 and 50 characters.");
        }
        VALID_LICENSE_KEY = licenseKey;
    }

    // Returns true if the provided license key is valid
    public static boolean validateLicense(String providedLicenseKey) {
        if (VALID_LICENSE_KEY == null || VALID_LICENSE_KEY.isEmpty()) {
            System.err.println("VALID_LICENSE_KEY is not set. Please configure the license key before validation.");
            return false;
        }
        if (providedLicenseKey == null || providedLicenseKey.isEmpty()) {
            System.err.println("License key cannot be null or empty.");
            return false;
        }
        return VALID_LICENSE_KEY.equals(providedLicenseKey);
    }

    // Checks the license key passed as an argument
    public static void runCheck(String[] args) {
        if (VALID_LICENSE_KEY == null) {
            System.err.println("No VALID_LICENSE_KEY has been configured. Exiting.");
            System.exit(1);
        }

        if (args == null || args.length == 0) {
            System.err.println("No license key provided. Please provide a valid license key.");
            System.exit(1);
        }

        String providedLicenseKey = args[0];

        if (!validateLicense(providedLicenseKey)) {
            System.err.println("Invalid license key. Please check your license and try again.");
            System.exit(1);
        }

        System.out.println("License successfully validated. Proceeding with program execution...");
    }

    // Main method to demonstrate usage
    public static void main(String[] args) {
        try {
            setValidLicenseKey("EXAMPLEKEYwjalrXUtnFEMIK7MDENGbPxRfiCY"); // Replace with actual key
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
            System.exit(1);
        }

        runCheck(args);

        // If the license check passes, the rest of the program can execute
        System.out.println("Application is now running...");
    }
}
