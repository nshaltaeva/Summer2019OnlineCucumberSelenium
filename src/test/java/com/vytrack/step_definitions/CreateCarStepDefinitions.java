package com.vytrack.step_definitions;

import com.vytrack.pages.CreateCarPage;
import com.vytrack.pages.VehiclesPage;
import com.vytrack.utilities.BrowserUtils;
import io.cucumber.java.en.Then;

import java.util.List;
import java.util.Map;

public class CreateCarStepDefinitions {

    CreateCarPage createCarPage = new CreateCarPage();
    VehiclesPage vehiclesPage = new VehiclesPage();

    @Then("user click on {string} button")
    public void user_click_on_button(String string) {
        vehiclesPage.waitUntilLoaderMaskDisappear();
        if(string.equals("Create Car")){
            vehiclesPage.clickToCreateACar();
        }

    }

//    Then user adds new car information:
//            | License Plate | Driver      | Location        | Model Year | Color |
//            | TestPlates    | Test Driver | Washington D.C. | 2020       | Black |
    // dataTable.get(0).get("Model Year") = 2020
    //get(0) - means get data from first row(excluding column names or header)
    //.get("Model Year") - get value of Model Year
    @Then("user adds new car information:")
    public void user_adds_new_car_information(List<Map<String,String>> dataTable) {
        createCarPage.waitUntilLoaderMaskDisappear();
        System.out.println(dataTable);
        int row = 1;
    for(Map<String, String> map: dataTable){
        createCarPage.licensePlateElement.sendKeys(map.get("License Plate"));
        createCarPage.driverElement.sendKeys(map.get("Driver"));
        createCarPage.locationElement.sendKeys(map.get("Location"));
        createCarPage.modelYearElement.sendKeys(map.get("Model Year"));
        createCarPage.colorElement.sendKeys(map.get("Color"));
        BrowserUtils.wait(2);
        if(row == dataTable.size()){
            createCarPage.clickSaveAndClose();
        }else{
            createCarPage.clickSaveAndAddNew();
        }
       BrowserUtils.wait(2);
        row++;
    }
    }

}
