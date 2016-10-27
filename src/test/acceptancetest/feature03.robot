Acceptance Tests

| *Setting* | *Value*                   |
| Library   | SwingLibrary              |

| *Test Case*                      | *Action*                          | *Argument*                       | *Argument*          |
| Test Gamegogy Default Values     | Start Application                 | edu.jsu.mcis.gamegogy.GUI.GamegogyGUI |                     |
|                                  | Select Window                     | Gamegogy                         |                     |
|                                  | ${courseId}=                      | Get Selected Item From Combo Box | CourseBox      |
|                                  | Should Be Equal                   | 99000                            | ${courseId}         |
|                                  | ${columnName}=                    | Get Selected Item From Combo Box | AssignmentBox      |
|                                  | Should Be Equal                   | Total                            | ${columnName}       |
|                                  | Label Text Should Be              | courseTerm                       | Spring 2013         |
|                                  | Label Text Should Be              | courseEnrollment                 | 11                  |
|                                  | Label Text Should Be              | studentId                        | ID: 111318              |
|                                  | Label Text Should Be              | studentName                      | Name: Cathleen Guzman     |
|                                  | Label Text Should Be              | studentEmail                     | Email: cguzman@jsu.edu     |
|                                  | Label Text Should Be              | studentScore                     | Score: 925.0               |
|                                  | Close Window                      | Gamegogy                         |                     |
| Test Gamegogy Course Select      | Start Application                 | edu.jsu.mcis.gamegogy.GUI.GamegogyGUI |                     |
|                                  | Select Window                     | Gamegogy                         |                     |
|                                  | Select From Combo Box             | CourseBox                   | 7                   |
|                                  | ${columnName}=                    | Get Selected Item From Combo Box | AssignmentBox      |
|                                  | Should Be Equal                   | Total                            | ${columnName}       |
|                                  | Label Text Should Be              | courseTerm                       | Spring 2012         |
|                                  | Label Text Should Be              | courseEnrollment                 | 7                   |
|                                  | Label Text Should Be              | studentId                        | ID: 111382              |
|                                  | Label Text Should Be              | studentName                      | Name: Mauricio Harrington |
|                                  | Label Text Should Be              | studentEmail                     | Email: mharrington@jsu.edu |
|                                  | Label Text Should Be              | studentScore                     | Score: 803.0               |
|                                  | Close Window                      | Gamegogy                         |                     |
| Test Gamegogy Column Select      | Start Application                 | edu.jsu.mcis.gamegogy.GUI.GamegogyGUI |                     |
|                                  | Select Window                     | Gamegogy                         |                     |
|                                  | Select From Combo Box             | CourseBox                   | 9                   |
|                                  | Select From Combo Box             | AssignmentBox                   | Assignment 7        |
|                                  | Label Text Should Be              | courseTerm                       | Spring 2012         |
|                                  | Label Text Should Be              | courseEnrollment                 | 25                  |
|                                  | Label Text Should Be              | studentId                        | ID: 111122              |
|                                  | Label Text Should Be              | studentName                      | Name: Vance McClain       |
|                                  | Label Text Should Be              | studentEmail                     | Email: vmcclain@jsu.edu    |
|                                  | Label Text Should Be              | studentScore                     | Score: 59.0                |
|                                  | Close Window                      | Gamegogy                         |                     |
