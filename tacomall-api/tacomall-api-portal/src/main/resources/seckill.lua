local function split(str, split_char)
    local sub_str_tab = {}
    while true do
        local pos = string.find(str, split_char)
        if not pos then
            table.insert(sub_str_tab, str)
            break
        end
        local sub_str = string.sub(str, 1, pos - 1)
        table.insert(sub_str_tab, sub_str)
        str = string.sub(str, pos + 1, string.len(str))
    end
    return sub_str_tab
end

if redis.call('SISMEMBER', KEYS[1], KEYS[2]) == 1 then
    return -1
end

local table_value = split(redis.call('GET', KEYS[3]), '/')

if tonumber(table_value[2]) <= 0 then
    return -2
end

redis.call('SET', KEYS[3], table_value[1] .. '/' .. table_value[2] - 1)

return redis.call('SADD', KEYS[1], KEYS[2])