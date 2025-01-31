------------------------------
Diffblue Custom Input Examples
------------------------------

Cover will natively generate tests that exercise as much of the method under test as possible, using its own analysis of the code.

However, additional context can be provided to Cover through custom inputs, allowing it to generate different or additional tests based on the supplied data.

Cover will assess the inputs and include those most suitable, though it may not necessarily use all provided inputs.

There are multiple methods available for different scenarios. This branch includes examples demonstrating the following custom input options:

1) DiffblueRules.yaml file: Providing example entries for different use cases - further information on these can be found on our documentation website (https://docs.diffblue.com/features/cover-cli/writing-tests/custom-inputs#custom-inputs)
	
	Immediate rules entries will be prioritised for consideration by Cover if identified as being relevant for the method under test
	
2) Test Factories: An additional class file setting out input values for an associating class; combined with a DiffblueRules file entry - further information on this can be found on our documentation website (https://docs.diffblue.com/features/cover-cli/writing-tests/custom-inputs#factory-rule)

	Stand-alone class files have been added for this example: UserFactory, DateAndTime and DateFactory
	To use the User factory please comment out the Username & password immediate rules within the DiffblueRules.yaml file and uncomment the "com.piggymetrics.account.domain.User" factory rule section

3) Annotations: A couple of example annotations that can be included directly within the class file to suggest inputs or promote methods ("InTest" & "interestingTestFactory") - further information on possible annotations can be found on our documentation website (https://docs.diffblue.com/features/cover-annotations/custom-input-annotations & https://docs.diffblue.com/features/cover-annotations/interesting-value-annotations)

	For the "InTest" annotation a stand-alone class file has been added for this example: UserValidator
	To use this annotation please comment out the Username & password immediate rules within the DiffblueRules.yaml file and uncomment the two "@InTestsUseStrings" sections within the class file
	
	For the "interestingTestFactory" annotation the "@InterestingTestFactory" section of the two factory files (DateFactory & UserFactory) can be uncommented

4) DiffblueBaseClass: Used as a super-class contain method to be run before writing tests - further information on this class file can be found on our documentation website (https://docs.diffblue.com/features/cover-cli/writing-tests/custom-test-setup#custom-base-class)

	Stand-alone class files have been added for this example: LicenseChecker and LicenseCheckerDiffblueBase
	Use cases of this class include scenarios where environment settings or licencing information would need to be set or reset before or after tests are executed.