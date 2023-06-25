import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { TestComponent } from './views/test/test.component';
import { TesttwoComponent } from './views/testtwo/testtwo.component';
import { TestthreeComponent } from './views/testthree/testthree.component';
import { TestfourComponent } from './views/testfour/testfour.component';
import { TestfiveComponent } from './views/testfive/testfive.component';

const routes: Routes = [
  { path: 'test', component: TestComponent },
  { path: 'testtwo', component: TesttwoComponent },
  { path: 'testthree', component: TestthreeComponent },
  { path: 'testfour', component: TestfourComponent },
  { path: 'testfive', component: TestfiveComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
