import { Pipe, PipeTransform } from '@angular/core';

import { Electronicdevice } from './electronicdevice/electronicdevice.model';

@Pipe({
  name: 'FilterElectronicdevice',
  pure: false
})
export class FilterElectronicdevice implements PipeTransform {
  transform(items: Electronicdevice[], filter: Electronicdevice): Electronicdevice[] {
    if (!items || !filter) {
      return items;
    }
    // filter items array, items which match and return true will be kept, false will be filtered out
    return items.filter((item: Electronicdevice) => this.applyFilter(item, filter));
  }

  /**
   * Perform the filtering.
   *
   * @param {Book} book The book to compare to the filter.
   * @param {Book} filter The filter to apply.
   * @return {boolean} True if book satisfies filters, false if not.
   */
  applyFilter(electronicdevice: Electronicdevice, filter: Electronicdevice): boolean {
    console.log("aaa"+electronicdevice.function);
    console.log("bbb"+filter.function);
    if (filter.function && electronicdevice.function.toLowerCase().indexOf(filter.function.toLowerCase()) === -1) {
      return false;
    }
    return true;
  }
}
