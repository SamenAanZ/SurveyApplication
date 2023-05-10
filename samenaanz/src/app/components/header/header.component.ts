import { Component, OnInit } from '@angular/core';
import { KeycloakService } from 'keycloak-angular';
import { angularEnvironment } from 'src/environments/environment';
import { Router } from '@angular/router';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {
  public userName: string = '';
  public isLoggedIn: boolean = false;

  constructor(private readonly router: Router, private readonly keycloakService: KeycloakService){}

   async ngOnInit(): Promise<void> {
    await this.keycloakService.loadUserProfile();
    this.isLoggedIn = await this.keycloakService.isLoggedIn();
    this.userName = this.keycloakService.getUsername();
  }

  async logout(): Promise<void>{
    this.keycloakService.logout(angularEnvironment.url);
  }

  isRoleAllowed(role: string): boolean {
    return this.keycloakService.isUserInRole(role);
  }

  navigate(url: string): void{
    this.router.navigateByUrl(url);
  }
}
