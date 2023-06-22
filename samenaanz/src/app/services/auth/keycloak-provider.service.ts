import { Injectable } from '@angular/core';
import { KeycloakService } from 'keycloak-angular';
import { ClaimType } from 'src/app/models/claim-types';

@Injectable({
  providedIn: 'root'
})
export class KeycloakProviderService {
  private decodedAccessToken: any;

  constructor(
    public readonly keycloakService: KeycloakService) {
      const encodedToken = this.keycloakService.getKeycloakInstance().token;
      this.decodedAccessToken = this.decodeAccessToken(encodedToken || '');
   }

  public getTokenClaim(claimName: ClaimType): any {
    const decoded = this.decodedAccessToken[claimName] || null;

    // Should be refactored in future
    if (claimName == ClaimType.roles)
      return decoded['roles'] as string[] || null;

    return this.decodedAccessToken[claimName] || null;
  }

  public getDecodedAccessToken(): Object {
    return this.decodedAccessToken;
  }

  private decodeAccessToken(token: string): any {
    const baseUrl = token.split('.')[1];
    const base64 = baseUrl.replace('-', '+').replace('_', '/');
    return JSON.parse(window.atob(base64));
  }
}
