*** README ***
1. This app demonstrates a small questionnaire
2. First question uses radio buttons where the user can select only one answer
3. Second question uses checkboxes where the user can select multiple answers.
   - If he selects the option "None of the above" then the the other checkboxes get disabled to prevent multiple selections.
   - If he selects the option "Other" then he is presented with a dialog where he can input his own custom answer. Pressing "OK"
     shows that answer in a textview below the checkboxes.
4. Save both the questions and answers in SQLite
5. On the next screen display the questions and their corresponding answers as fetched from SQLite.