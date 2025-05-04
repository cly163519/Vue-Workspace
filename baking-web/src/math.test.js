import {add} from '/src/math';

test('2+3 should be equal to 5',()=>{
    const result = add(2,3);
    expect(result).toBe(5);
});