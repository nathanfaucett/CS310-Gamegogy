*** Settings ***
Library           SwingLibrary
Library           keywords.GamegogyKeywords


*** Keywords ***
Some Function    [Arguments]   ${a}    ${b}
    ${return}=    Some Custom Function    ${a}    ${b}
    Should Be True    ${return}


*** Test Cases ***
Some Test Case
    Some Function    "String"    "String"
