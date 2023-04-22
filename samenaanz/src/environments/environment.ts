export const keycloakEnvironment = {
    // Keycloak instance settings
    url: "http://localhost:8080/",
    realm: "myrealm",
    client: "myclient",

    // Settings that check if the user is still logged in
    checkLogin: true,
    checkLoginTimeSeconds: 25
}

export const angularEnvironment = {
    url: "http://localhost:4200/"
}