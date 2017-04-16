import { Pipe, PipeTransform } from '@angular/core';

import { Heater } from './heater/heater.model';

@Pipe({
  name: 'FilterHeater',
  pure: false
})
export class FilterHeater implements PipeTransform {
  transform(items: Heater[], filter: Heater): Heater[] {
    if (!items || !filter) {
      return items;
    }
    // filter items array, items which match and return true will be kept, false will be filtered out
    return items.filter((item: Heater) => this.applyFilter(item, filter));
  }

  /**
   * Perform the filtering.
   *
   * @param {Book} book The book to compare to the filter.
   * @param {Book} filter The filter to apply.
   * @return {boolean} True if book satisfies filters, false if not.
   */
  applyFilter(home: Heater, filter: Heater): boolean {
    if(filter.idHeater && filter.idHeater != home.idHeater){
      return false;
    }
    return true;
  }
}
