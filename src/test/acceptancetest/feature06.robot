Acceptance Tests

| *Setting* | *Value*                   |
| Library   | SwingLibrary              |
| Library   | String                    |
| Library   | Collections               |
| Library   | keywords.GamegogyGUIKeywords |

| *Keyword*                        | *Action*           | *Argument*                         | *Argument*  |          |
| Is Menu Item Selected            | [Arguments]        | ${menuText}                        |             |          |
|                                  | @{menus}=          | Split String                       | ${menuText} |  \|       |
|                                  | ${lastItem}=       | Remove From List                   | ${menus}    | -1       |
|                                  | :FOR               | ${menu}                            | IN          | @{menus} |
|                                  |                    | Select From Menu                   | ${menu}     |          |
|                                  | ${selected}=       | Radio Button Menu Item Is Selected | ${lastItem} |          |
|                                  | [return]           | ${selected}                        |             |          |
| Menu Item Should Be Selected     | [Arguments]        | ${menuText}                        |             |          |
|                                  | ${selected}=       | Is Menu Item Selected              | ${menuText} |          |
|                                  | Should Be True     | ${selected}                        |             |          |
| Menu Item Should Not Be Selected | [Arguments]        | ${menuText}                        |             |          |
|                                  | ${selected}=       | Is Menu Item Selected              | ${menuText} |          |
|                                  | Should Not Be True | ${selected}                        |             |          |


| *Test Case*                      | *Action*                         | *Argument*                       | *Argument*       |
| Test Default File Source         | Start Application                | edu.jsu.mcis.gamegogy.GUI.GamegogyGUI   |                  |
|                                  | Select Window                    | Gamegogy                         |                  |
|                                  | Menu Item Should Be Selected     | Source|ResourceFile                    |                  |
|                                  | Menu Item Should Not Be Selected | WebService                      |                  |
|                                  | Close Window                     | Gamegogy                         |                  |
| Test Web Service Source          | Start Application                | edu.jsu.mcis.gamegogy.GUI.GamegogyGUI   |                  |
|                                  | Select Window                    | Gamegogy                         |                  |
|                                  | ${courseId}=                     | Get Selected Item From Combo Box | CourseBox   |
|                                  | Should Be Equal                  | 99000                            | ${courseId}      |
|                                  | ${columnName}=                   | Get Selected Item From Combo Box | AssignmentBox   |
|                                  | Should Be Equal                  | Total                            | ${columnName}    |
|                                  | Select From Combo Box            | CourseBox                   | 9                |
|                                  | Select From Combo Box            | AssignmentBox                   | Assignment 7     |
|                                  | Label Text Should Be             | courseTerm                       | Spring 2012      |
|                                  | Label Text Should Be             | courseEnrollment                 | 25               |
|                                  | Label Text Should Be             | studentId                        | ID: 111122           |
|                                  | Label Text Should Be             | studentName                      | Name: Vance McClain    |
|                                  | Label Text Should Be             | studentEmail                     | Email: vmcclain@jsu.edu |
|                                  | Label Text Should Be             | studentScore                     | Score: 59.0             |
|                                  | Select From Menu                 | Source|WebService               |                  |
|                                  | Menu Item Should Not Be Selected | Source|ResourceFile             |                  |
|                                  | Menu Item Should Be Selected     | WebService                      |                  |
|                                  | ${courseId}=                     | Get Selected Item From Combo Box | CourseBox   |
|                                  | Should Be Equal                  | 99000                            | ${courseId}      |
|                                  | ${columnName}=                   | Get Selected Item From Combo Box | AssignmentBox   |
|                                  | Should Be Equal                  | Total                            | ${columnName}    |
|                                  | Close Window                     | Gamegogy                         |                  |
| Test Reselected File Source      | Start Application                | edu.jsu.mcis.gamegogy.GUI.GamegogyGUI   |                  |
|                                  | Select Window                    | Gamegogy                         |                  |
|                                  | Select From Menu                 | WebService               |                  |
|                                  | ${courseId}=                     | Get Selected Item From Combo Box | CourseBox   |
|                                  | Should Be Equal                  | 99000                            | ${courseId}      |
|                                  | ${columnName}=                   | Get Selected Item From Combo Box | AssignmentBox   |
|                                  | Should Be Equal                  | Total                            | ${columnName}    |
|                                  | Select From Combo Box            | CourseBox                   | 9                |
|                                  | Select From Combo Box            | AssignmentBox                   | Assignment 7     |
|                                  | Label Text Should Be             | courseTerm                       | Spring 2012      |
|                                  | Label Text Should Be             | courseEnrollment                 | 25               |
|                                  | Label Text Should Be             | studentId                        | ID: 111122           |
|                                  | Label Text Should Be             | studentName                      | Name: Vance McClain    |
|                                  | Label Text Should Be             | studentEmail                     | Email: vmcclain@jsu.edu |
|                                  | Label Text Should Be             | studentScore                     | Score: 59.0             |
|                                  | Select From Menu                 | Source|ResourceFile             |                  |
|                                  | Menu Item Should Be Selected     | Source|ResourceFile             |                  |
|                                  | Menu Item Should Not Be Selected | WebService                      |                  |
|                                  | ${courseId}=                     | Get Selected Item From Combo Box | CourseBox   |
|                                  | Should Be Equal                  | 99000                            | ${courseId}      |
|                                  | ${columnName}=                   | Get Selected Item From Combo Box | AssignmentBox   |
|                                  | Should Be Equal                  | Total                            | ${columnName}    |
|                                  | Close Window                     | Gamegogy                         |                  |