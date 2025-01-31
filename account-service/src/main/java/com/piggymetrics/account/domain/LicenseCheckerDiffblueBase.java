package com.piggymetrics.account.domain;

import org.junit.jupiter.api.BeforeEach;

public class LicenseCheckerDiffblueBase {

    @BeforeEach
    void setLicenseKey() {
        LicenseChecker.setValidLicenseKey("12312312414fdgdfgfdgdfGbPxRfiCY");
    }

}