import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule }   from '@angular/forms';
import { RouterModule, Routes } from '@angular/router';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { ViewHistoryComponent } from './view-history/view-history.component';
import { EmployeeComponent } from './employee/employee.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { ApplyLeaveComponent } from './apply-leave/apply-leave.component';
import { EmployeeDetailsComponent } from './employee-details/employee-details.component';
import { ManagerDetailsComponent } from './manager-details/manager-details.component';
import {ChatModule} from './chat/chat.module'
import { ChatDialogComponent } from './chat/chat-dialog/chat-dialog.component';
import { PendingComponent } from './pending/pending.component';
import { ManagerActionsComponent } from './manager-actions/manager-actions.component';

const appRoute : Routes = [
{path:"", redirectTo:"home", pathMatch:"full"},
{path:"home", component:EmployeeComponent},
{path:"login", component :LoginComponent},
{path:"leaveHistory", component :ViewHistoryComponent},
{path:"dashboard", component :DashboardComponent},
{path:"pending",component:PendingComponent},
{path:"myDetails",component:EmployeeDetailsComponent},
{path:"mgrDetails",component:ManagerDetailsComponent},
{path:"applyleave", component:ApplyLeaveComponent},
{path:"manager", component:ManagerActionsComponent},
{path:"hexaBot", component:ChatDialogComponent}
];


@NgModule({
  declarations: [
    AppComponent,
    ManagerActionsComponent,
    LoginComponent,
    ViewHistoryComponent,
    EmployeeComponent,
    DashboardComponent,
    PendingComponent,
    EmployeeDetailsComponent,
    ManagerDetailsComponent,
    ApplyLeaveComponent,
    PendingComponent,
    ApplyLeaveComponent
  ],
  imports: [
    BrowserModule,HttpClientModule,
    FormsModule, ChatModule,ReactiveFormsModule,
    RouterModule.forRoot(appRoute)
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
