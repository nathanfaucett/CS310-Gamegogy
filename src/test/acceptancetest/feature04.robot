Acceptance Tests

| *Setting* | *Value*                      |
| Library   | keywords.GamegogyGUIKeywords |
| Library   | SwingLibrary                 |

| *Test Case*                      | *Action*                          | *Argument*                       | *Argument*          |
| Test Click Leaderboard Lowest    | Start Application                 | edu.jsu.mcis.gamegogy.GUI.GamegogyGUI |                     |
|                                  | Select Window                     | Gamegogy                         |                     |
|                                  | Click Leaderboard Bar At Index    | 10                               |                     |
|                                  | Label Text Should Be              | studentId                        | ID: 111141              |
|                                  | Label Text Should Be              | studentName                      | Name: Forest Rasmussen    |
|                                  | Label Text Should Be              | studentEmail                     | Email: frasmussen@jsu.edu  |
|                                  | Label Text Should Be              | studentScore                     | Score: 381.0               |
|                                  | Close Window                      | Gamegogy                         |                     |
| Test Click Leaderboard Highest   | Start Application                 | edu.jsu.mcis.gamegogy.GUI.GamegogyGUI |                     |
|                                  | Select Window                     | Gamegogy                         |                     |
|                                  | Click Leaderboard Bar At Index    | 0                                |                     |
|                                  | Label Text Should Be              | studentId                        | ID: 111318              |
|                                  | Label Text Should Be              | studentName                      | Name: Cathleen Guzman     |
|                                  | Label Text Should Be              | studentEmail                     | Email: cguzman@jsu.edu     |
|                                  | Label Text Should Be              | studentScore                     | Score: 925.0               |
|                                  | Close Window                      | Gamegogy                         |                     |
| Test Click Leaderboard Middle    | Start Application                 | edu.jsu.mcis.gamegogy.GUI.GamegogyGUI |                     |
|                                  | Select Window                     | Gamegogy                         |                     |
|                                  | Click Leaderboard Bar At Index    | 6                                |                     |
|                                  | Label Text Should Be              | studentId                        | ID: 111335              |
|                                  | Label Text Should Be              | studentName                      | Name: Ira Richardson      |
|                                  | Label Text Should Be              | studentEmail                     | Email: irichardson@jsu.edu |
|                                  | Label Text Should Be              | studentScore                     | Score: 558.0               |
|                                  | Close Window                      | Gamegogy                         |                     |
