import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, Router, RouterStateSnapshot } from '@angular/router';
import { KeycloakAuthGuard, KeycloakService } from 'keycloak-angular';
import { ApplicationRole } from '../models/application-roles';

@Injectable({
  providedIn: 'root'
})
export class AuthGuard extends KeycloakAuthGuard {
  constructor(protected override readonly router: Router, protected readonly keycloak: KeycloakService) {
    super(router, keycloak);
  }

  public async isAccessAllowed(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) : Promise<boolean> {
    
    // Force the user to log in if currently unauthenticated.
    if (!this.authenticated) {
      await this.keycloak.login({
        redirectUri: window.location.origin + state.url
      });
    }

    // Get the roles required from the route. (These are passed when defining the route)
    const requiredRoles = route.data['roles'];

    // Allow the user to proceed if no additional roles are required to access the route.
    if (!(requiredRoles instanceof Array) || requiredRoles.length === 0) {
      return true;
    }

    // Check if required role exists
    const hasRequiredRole = requiredRoles.some((role) => this.roles.includes(role));
    //return requiredRoles.every((role) => this.roles.includes(role));

    // If user does not have the required role, redirect to unauthorized page
    if (!hasRequiredRole)
    {
      await this.router.navigate(['/unauthorized']);
      return false;
    }

    return true;
  }
}