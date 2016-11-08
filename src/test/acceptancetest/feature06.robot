Acceptance Tests
    
| *Setting* | *Value*                   |
| Library   | SwingLibrary              |
| Library   | String                    |
| Library   | Collections               |
| Library   | keywords.GamegogyGUIKeywords |

| *Keyword*                        | *Action*           | *Argument*                         | *Argument*  |          |
| Is Menu Item Selected            | [Arguments]        | ${menuText}                        |             |          |
|                                  | ${selected}=       | Radio Button Should Be Selected | ${menuText} |          |
|                                  | [return]           | ${selected}                        |             |          |
| Menu Item Should Be Selected     | [Arguments]        | ${menuText}                        |             |          |
|                                  | ${selected}=       | Is Menu Item Selected              | ${menuText} |          |
|                                  | Should Be Equal     | ${selected}                        |    None         |          |
| Menu Item Should Not Be Selected | [Arguments]        | ${menuText}                        |             |          |
|                                  | ${selected}=       | Is Menu Item Selected              | ${menuText} |          |
|                                  | Should Not Be Equal | ${selected}                        |    None         |          |


| *Test Case*                      | *Action*                         | *Argument*                       | *Argument*       |
| Test Default File Source         | Start Application                | edu.jsu.mcis.gamegogy.GUI.GamegogyGUI   |                  |
|                                  | Select Window                    | Gamegogy                         |                  |
|                                  | Menu Item Should Be Selected     | CSV             |                  |
|                                  | Menu Item Should Not Be Selected | JSON                      |                  |
|                                  | Close Window                     | Gamegogy                         |                  |
| Test Web Service Source          | Start Application                | edu.jsu.mcis.gamegogy.GUI.GamegogyGUI   |                  |
|                                  | Select Window                    | Gamegogy                         |                  |
|                                  | ${courseId}=                     | Get Selected Item From Combo Box | ComboBox   |
|                                  | Should Be Equal                  | 99000                            | ${courseId}      |
|                                  | ${columnName}=                   | Get Selected Item From Combo Box | AssignmentBox   |
|                                  | Should Be Equal                  | Total                            | ${columnName}    |
|                                  | Select From Combo Box            | ComboBox                   | 9                |
|                                  | Select From Combo Box            | AssignmentBox                   | Assignment 7     |
|                                  | Label Text Should Be             | courseTerm                       | Spring 2012      |
|                                  | Label Text Should Be             | courseEnrollment                 | 25               |
|                                  | Label Text Should Be             | studentId                        | ID: 111122           |
|                                  | Label Text Should Be             | studentName                      | Name: Vance McClain    |
|                                  | Label Text Should Be             | studentEmail                     | Email: vmcclain@jsu.edu |
|                                  | Label Text Should Be             | studentScore                     | Score: 59.0             |
|                                  | Push Radio Button                 | JSON               |                  |
|                                  | Menu Item Should Not Be Selected | CSV             |                  |
|                                  | Menu Item Should Be Selected     | JSON                      |                  |
|                                  | ${courseId}=                     | Get Selected Item From Combo Box | ComboBox   |
|                                  | Should Be Equal                  | 99000                            | ${courseId}      |
|                                  | ${columnName}=                   | Get Selected Item From Combo Box | AssignmentBox   |
|                                  | Should Be Equal                  | Total                            | ${columnName}    |
|                                  | Close Window                     | Gamegogy                         |                  |
| Test Reselected File Source      | Start Application                | edu.jsu.mcis.gamegogy.GUI.GamegogyGUI   |                  |
|                                  | Select Window                    | Gamegogy                         |                  |
|                                  | Push Radio Button                 | JSON               |                  |
|                                  | ${courseId}=                     | Get Selected Item From Combo Box | ComboBox   |
|                                  | Should Be Equal                  | 99000                            | ${courseId}      |
|                                  | ${columnName}=                   | Get Selected Item From Combo Box | AssignmentBox   |
|                                  | Should Be Equal                  | Total                            | ${columnName}    |
|                                  | Select From Combo Box            | ComboBox                   | 9                |
|                                  | Select From Combo Box            | AssignmentBox                   | Assignment 7     |
|                                  | Label Text Should Be             | courseTerm                       | Spring 2012      |
|                                  | Label Text Should Be             | courseEnrollment                 | 25               |
|                                  | Label Text Should Be             | studentId                        | ID: 111122           |
|                                  | Label Text Should Be             | studentName                      | Name: Vance McClain    |
|                                  | Label Text Should Be             | studentEmail                     | Email: vmcclain@jsu.edu |
|                                  | Label Text Should Be             | studentScore                     | Score: 59.0             |
|                                  | Push Radio Button                 | CSV             |                  |
|                                  | Menu Item Should Be Selected     | CSV             |                  |
|                                  | Menu Item Should Not Be Selected | JSON                      |                  |
|                                  | ${courseId}=                     | Get Selected Item From Combo Box | ComboBox   |
|                                  | Should Be Equal                  | 99000                            | ${courseId}      |
|                                  | ${columnName}=                   | Get Selected Item From Combo Box | AssignmentBox   |
|                                  | Should Be Equal                  | Total                            | ${columnName}    |
|                                  | Close Window                     | Gamegogy                         |                  |