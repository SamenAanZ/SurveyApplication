import { Component, OnInit } from '@angular/core';
import { KeycloakService } from 'keycloak-angular';
import { KeycloakProfile } from 'keycloak-js';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {
  public profile: KeycloakProfile | null = null;
  
  constructor(private readonly keycloakService: KeycloakService) {}

  async ngOnInit(): Promise<void> {
    this.profile = await this.keycloakService.loadUserProfile();
  }

  public async navigateToProfile(): Promise<void> {
    await this.keycloakService.getKeycloakInstance().accountManagement();
  }
}
