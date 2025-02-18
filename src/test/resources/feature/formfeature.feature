Feature: Filling form from DemoQA

	Scenario: Filling the form
		Given I visit "https://demoqa.com/automation-practice-form"
		When I fill in the details
  |FirstName | LastName |Email        | Gender |mobile    |Date        |Subjects |hobbies|address   |state|city|
  |Mpho      | Mokoes   |mp@gmail.com | Male   |0832864301 |June 16th, 2020|Chemistry,English|Sports |55 rose st|NCR  |Delhi|
  Then submit the form and get confirmation text
  