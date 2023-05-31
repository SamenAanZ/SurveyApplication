export const keycloakEnvironment = {
    // Keycloak instance settings
    url: "http://localhost:8080",
    realm: "SamenAanZ",
    client: "samenaanz-frontend",

    // Settings that check if the user is still logged in
    checkLogin: true,
    checkLoginTimeSeconds: 25
}

export const angularEnvironment = {
    url: "http://localhost:4200"
}

export const surveyCreatorSettings = {
    questionTypes: ['radiogroup'],
    pages: [
        {
          name: "page1",
          elements: []
        }
      ],
    showLogicTab: false,
    isAutoSave: false,
    showTimerPanel: false,
    showPagesToolbox: false,
    showPropertyGrid: false,
    showOptions: false,
    showJSONEditorTab: false,
    showTranslationTab: false,
}

export const defaultSurveyCreatorTemplate = {
    "title": "Demo Survey",
    "description": "This is a Demo Survey",
}

export const surveyEndpoints = {
    URL: ""
}