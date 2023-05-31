import { Component, OnInit } from '@angular/core';
import { KeycloakService } from 'keycloak-angular';
import { KeycloakProfile } from 'keycloak-js';
import { ClaimType } from 'src/app/models/claim-types';
import { KeycloakProviderService } from 'src/app/services/auth/keycloak-provider.service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {
  public organization: string = '';
  public profile: KeycloakProfile | null = null;
  
  constructor(
    private readonly keycloakService: KeycloakService, 
    private readonly provider: KeycloakProviderService) {}

  async ngOnInit(): Promise<void> {
    this.profile = await this.keycloakService.loadUserProfile();
    this.organization = await this.provider.getTokenClaim(ClaimType.organization);
  }

  public async navigateToProfile(): Promise<void> {
    await this.keycloakService.getKeycloakInstance().accountManagement();
  }
}
