import { browser, logging } from 'protractor';
import faker = require('faker');

describe('Create appointment test', () => {
  let page: AppointmentPage;
  let newAppointmentPage: NewAppointmentPage;

  beforeEach(() => {
    page = new AppointmentPage();
    newAppointmentPage = new NewAppointmentPage();
  });

  it('should create a new appointment', async () => {
    await page.navigateTo();
    await page.clickNewButton();
    await newClientPage.setDocumentNumber(faker.random.number({ min: 10000000, max: 9999999999 }));
    newClientPage.setFullName(faker.name.findName());
    await newClientPage.clickSave();
    expect(newClientPage.snackbarExists()).toBeTruthy();
  });

  afterEach(async () => {
    // Assert that there are no errors emitted from the browser
    const logs = await browser.manage().logs().get(logging.Type.BROWSER);
    expect(logs).not.toContain(jasmine.objectContaining({
      level: logging.Level.SEVERE,
    } as logging.Entry));
  });
});
