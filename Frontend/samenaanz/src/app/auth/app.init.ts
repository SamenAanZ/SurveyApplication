import { KeycloakService } from "keycloak-angular";
import { angularEnvironment, keycloakEnvironment } from "../../environments/environment";

export function initializeKeycloak(keycloak: KeycloakService) : () => Promise<boolean> {
    return () =>
      keycloak.init({
        config: {
          url: keycloakEnvironment.url,
          realm: keycloakEnvironment.realm,
          clientId: keycloakEnvironment.client
        },
        
        initOptions: {
          redirectUri: angularEnvironment.url,
          checkLoginIframe: keycloakEnvironment.checkLogin,
          checkLoginIframeInterval: keycloakEnvironment.checkLoginTimeSeconds
        },
      });
  }