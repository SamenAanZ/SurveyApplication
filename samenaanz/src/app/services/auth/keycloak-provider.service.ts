import { Injectable } from '@angular/core';
import { KeycloakService } from 'keycloak-angular';

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

  public getTokenClaim(claimName: string): any {
    return this.decodedAccessToken[claimName] || null;
  }

  public getUserId(): string {
    return this.getTokenClaim('sub') || null;
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
