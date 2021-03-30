import { AbstractControl, ValidationErrors } from '@angular/forms';

const EXPLICIT_WORDS = ['GRYBAS', 'LEPSIS'];
export const explicitValidator = (
  control: AbstractControl
): ValidationErrors | null => {
  const explicitWords = control.value
    .toUpperCase()
    .split(' ')
    .filter((word) => EXPLICIT_WORDS.includes(word));
  return explicitWords.length ?
    { explicitLanguage: { words: explicitWords.join(',') } }
    : null;
};
