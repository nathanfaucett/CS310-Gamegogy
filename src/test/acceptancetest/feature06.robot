Acceptance Tests
    
| *Setting* | *Value*                   |
| Library   | SwingLibrary              |
| Library   | String                    |
| Library   | Collections               |
| Library   | keywords.MenuItemKeywords |

| *Keyword*                        | *Action*           | *Argument*                         | *Argument*  |          |
| Is Menu Item Selected            | [Arguments]        | ${menuText}                        |             |          |
|                                  | @{menus}=          | Split String                       | ${menuText} | \|       |
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
| Test Default File Source         | Start Application                | edu.jsu.mcis.gamegogy.Gamegogy   |                  |
|                                  | Select Window                    | Gamegogy                         |                  |
|                                  | Menu Item Should Be Selected     | Source|Resource File             |                  |
|                                  | Menu Item Should Not Be Selected | Web Service                      |                  |
|                                  | Close Window                     | Gamegogy                         |                  |
| Test Web Service Source          | Start Application                | edu.jsu.mcis.gamegogy.Gamegogy   |                  |
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
|                                  | Select From Menu                 | Source|Web Service               |                  |
|                                  | Menu Item Should Not Be Selected | Source|Resource File             |                  |
|                                  | Menu Item Should Be Selected     | Web Service                      |                  |
|                                  | ${courseId}=                     | Get Selected Item From Combo Box | ComboBox   |
|                                  | Should Be Equal                  | 99000                            | ${courseId}      |
|                                  | ${columnName}=                   | Get Selected Item From Combo Box | AssignmentBox   |
|                                  | Should Be Equal                  | Total                            | ${columnName}    |
|                                  | Close Window                     | Gamegogy                         |                  |
| Test Reselected File Source      | Start Application                | edu.jsu.mcis.gamegogy.Gamegogy   |                  |
|                                  | Select Window                    | Gamegogy                         |                  |
|                                  | Select From Menu                 | Source|Web Service               |                  |
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
|                                  | Select From Menu                 | Source|Resource File             |                  |
|                                  | Menu Item Should Be Selected     | Source|Resource File             |                  |
|                                  | Menu Item Should Not Be Selected | Web Service                      |                  |
|                                  | ${courseId}=                     | Get Selected Item From Combo Box | ComboBox   |
|                                  | Should Be Equal                  | 99000                            | ${courseId}      |
|                                  | ${columnName}=                   | Get Selected Item From Combo Box | AssignmentBox   |
|                                  | Should Be Equal                  | Total                            | ${columnName}    |
|                                  | Close Window                     | Gamegogy                         |                  |