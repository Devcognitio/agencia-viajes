import { Vuelo } from './vuelo';

describe('Vuelo', () => {
  it('should create an instance', () => {
    expect(new Vuelo('v1','avianca','00:00','03:00',"true",false)).toBeTruthy();
  });
});
